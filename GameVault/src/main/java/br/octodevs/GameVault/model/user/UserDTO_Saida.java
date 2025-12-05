package br.octodevs.GameVault.model.user;

import br.octodevs.GameVault.model.game.Game;

public record UserDTO_Saida(
        Long userId,
        String userName
) {
    public UserDTO_Saida(User user){
        this(user.getUserId(), user.getPassword());
    }
}
