import { View, Text, Image, StyleSheet } from "react-native";
import PerfilData from "../models/PerfilData";
import ContainerPerfil from "./containerPerfil";


interface ContainerPerfilTitulo{
    perfil:PerfilData;
    titulo: string;
}

const ContainerPerfilTitulo:React.FC<ContainerPerfilTitulo> = ({perfil,titulo}) => {
    return(
        <View style={styles.containerTitulo}>
            <Text style={styles.textoTitulo}>{titulo}</Text>
            <ContainerPerfil nome={perfil.nome}  foto={perfil.foto} />
        </View>
    )
}



const styles = StyleSheet.create({     
    containerTitulo:{
        flexDirection: "row",
        justifyContent: "space-between",
        alignItems: "center",
        // backgroundColor: "rgb(10,10,10)",
        marginTop: 30,
        marginLeft: 20,
        marginRight: 10,
        height: 30
    },
    textoTitulo:{
        color: "rgb(255, 255, 255)",
        fontSize: 14
    }    
});

export default ContainerPerfilTitulo;