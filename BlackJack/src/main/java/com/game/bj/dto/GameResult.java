package com.game.bj.dto;

public enum GameResult {
    COMPUTER, // win computer cScore > pScore && cScore <= 21,
    PLAYER,  // win player  pScore > cScore && pScore <= 21,
    DRAW, // draw pScore == cScore
    LOSE; // lose player pScore > 21 && cScore > 21
}
