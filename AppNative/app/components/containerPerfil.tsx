import { View, Text, Image, StyleSheet } from "react-native";


// Todo -> Conteudo Dinamico 
export default function ContainerPerfil(){
    return(
        <View style={styles.containerTitulo}>
            <Text style={styles.textoTitulo}>Peronsa 5 Royal</Text>
            <View style={styles.containerPerfil}>
                <Text style={styles.textoPerfil}>Fernando B.</Text>
                <Image source={require("@/assets/images/persona5.jpg")} style={styles.imagePerfil} />
            </View>
        </View>
    )
}



const styles = StyleSheet.create({
    imagePerfil:{
        height:30,
        width:30,
        borderRadius: 30,
    }, 
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
    containerPerfil:{
        flexDirection: "row",
        justifyContent: "space-between",
        width: 115,        
        alignItems: "center",
        // backgroundColor: "rgb(10,10,10)",
    },
    textoTitulo:{
        color: "rgb(255, 255, 255)",
        fontSize: 14
    },
    textoPerfil:{
        fontSize: 12,
        color: "rgb(255, 255, 255)",
    }
});