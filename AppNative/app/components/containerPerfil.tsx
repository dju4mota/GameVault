import { View, Text, Image, StyleSheet } from "react-native";
import PerfilData from "../models/PerfilData";



const ContainerPerfil:React.FC<PerfilData> = ({nome,foto}) => {    
    return(        
        <View style={styles.containerPerfil}>
            <Text style={styles.textoPerfil}>{nome}</Text>
            <Image source={require("@/assets/images/persona5.jpg")} style={styles.imagePerfil} />
        </View>    
    )
}



const styles = StyleSheet.create({
    imagePerfil:{
        height:30,
        width:30,
        borderRadius: 30,
    },     
    containerPerfil:{
        flexDirection: "row",
        justifyContent: "space-between",
        width: 115,        
        alignItems: "center",
        // backgroundColor: "rgb(10,10,10)",
    },
    textoPerfil:{
        fontSize: 12,
        color: "rgb(255, 255, 255)",
    }
});

export default ContainerPerfil;