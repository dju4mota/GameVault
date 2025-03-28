import { ApiService } from "@/services/ApiService";
import axios from "axios";
import { Children, createContext, useContext, useEffect, useState } from "react";
import * as SecureStore from 'expo-secure-store';


interface AuthProps { 
    authState?: {token: string | null; authenticated: boolean | null;}
    onRegister?: (userName:string, password : string) => Promise<any>;
    onLogin?: (userName:string, password : string) => Promise<any>;
    onLogout?: () => Promise<any>;

}

const TOKEN_Key = 'my-jwt';
export const API_URL = ApiService.apiUrl;
const AuthContext  = createContext<AuthProps>({});

export const useAuth = () => {
    return useContext(AuthContext);
}

export const AuthProvider = ({children}: any) => {
    const [authSate, setAuthState] = useState<{
        token : string |null;
        authenticated: boolean | null;
    }>({
        token: null,
        authenticated: null
    })

    useEffect(() => {
        const loadToken = async () => {
            const token = await SecureStore.getItemAsync( TOKEN_Key)
            if(token){
                axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;

                setAuthState({
                    token: token,
                    authenticated: true
                }) 
            }
        }
        loadToken()
    },[])

    const register = async (username:string, password: string) => {
        try{ 
            return await axios.post(`${API_URL}/auth/register`, {username,password});
        } catch (e){
            return {error: true, msg: (e as any).response.data.msg}
        }
    }

    const login = async (username:string, password: string) => {
        try{ 
            const result =  await axios.post(`${API_URL}/auth/login`, {username,password});
            
            setAuthState({
                token: result.data.token,
                authenticated: true
            }) 

            axios.defaults.headers.common[`Authorization`] = `Bearer ${result.data.token}`;

            await SecureStore.setItemAsync(TOKEN_Key,result.data.token);
            
            return result;

        } catch (e){
            return {error: true, msg: (e as any).response.data.msg}
        }
    }

    const logout = async () => {
        await SecureStore.deleteItemAsync(TOKEN_Key)

        axios.defaults.headers.common["Authorization"] = "";

        setAuthState({
            token: null,
            authenticated: false
        })

    }

    const value = {
        onRegister: register,
        onLogin: login,
        onLogout: logout,
        authSate

    }
    
    return <AuthContext.Provider value={value}>{children}</AuthContext.Provider> 
}

