package br.octodevs.GameVault.model.game;

public record GameDTO_Saida(
        Long gameId,
        String title,
        String description,
        String genre
) {
    public GameDTO_Saida(Game game){
        this(game.getGameId(),game.getTitle(), game.getDescription(), game.getGenre());
    }
}
