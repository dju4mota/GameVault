import { Stack } from "expo-router";

export default function RootLayout() {
  return <Stack  
      screenOptions={{
        headerShown: false, // Oculta o cabeçalho em todas as telas
        // statusBarBackgroundColor:"rgb(255, 72, 0)",
      }}>
          <Stack.Screen name="reviewDetails" />
          <Stack.Screen name="gameDetails" />
      </Stack>
      
  ;
}
