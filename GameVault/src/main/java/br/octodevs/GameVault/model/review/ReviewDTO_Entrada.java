package br.octodevs.GameVault.model.review;

import br.octodevs.GameVault.utils.Platform;

public record ReviewDTO_Entrada(
        Long score,
        String comment,
        String data,
        Platform platform,
        Long gameId,
        Long userId,
        Float hoursPlayed) {
}
