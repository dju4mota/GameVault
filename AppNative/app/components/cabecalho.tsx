import {Text, TouchableOpacity, View} from "react-native";
import Icon from "react-native-vector-icons/MaterialIcons";

export  function Cabecalho() {
    const handleMenuPress = () => {
        console.log('Menu pressionado!');
    };
    return (
        <View style={{
            alignItems: "center",
            flexDirection: 'row',
        }}>
            <View style={{ padding: 20 }}>
                <TouchableOpacity onPress={handleMenuPress}>
                    <Icon name="menu" size={30} color="#000" />
                </TouchableOpacity>
            </View>
            <View
                style={{
                    flex: 1,
                    justifyContent: "space-around",
                    alignItems: "center",
                    flexDirection: 'row',
                }}
            >
                <Text>Jogos</Text>
                <Text>Reviews</Text>
                <Text>Listas</Text>

            </View>
        </View>
    );
}