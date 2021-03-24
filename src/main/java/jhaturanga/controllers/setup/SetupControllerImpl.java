package jhaturanga.controllers.setup;

import java.util.Optional;

import jhaturanga.commons.Pair;
import jhaturanga.controllers.AbstractController;
import jhaturanga.model.game.gametypes.GameTypesEnum;
import jhaturanga.model.match.Match;
import jhaturanga.model.match.builder.MatchBuilderImpl;
import jhaturanga.model.player.Player;
import jhaturanga.model.timer.DefaultTimers;

public final class SetupControllerImpl extends AbstractController implements SetupController {

    private GameTypesEnum gameType;
    private DefaultTimers timer;
    private WhitePlayerChoice choice;

    @Override
    public void setGameType(final GameTypesEnum gameType) {
        this.gameType = gameType;
    }

    @Override
    public void setTimer(final DefaultTimers timer) {
        this.timer = timer;
    }

    @Override
    public void setWhitePlayerChoice(final WhitePlayerChoice choice) {
        this.choice = choice;
    }

    @Override
    public Optional<GameTypesEnum> getSelectedGameType() {
        return Optional.ofNullable(this.gameType);
    }

    @Override
    public Optional<DefaultTimers> getSelectedTimer() {
        return Optional.ofNullable(this.timer);
    }

    @Override
    public Optional<WhitePlayerChoice> getSelectedWhitePlayerChoice() {
        return Optional.ofNullable(this.choice);
    }

    @Override
    public boolean createMatch() {
        if (this.gameType == null || this.timer == null || this.choice == null) {
            return false;
        }
        final Pair<Player, Player> players = this.choice.getPlayers(this.getApplicationInstance().getFirstUser().get(),
                this.getApplicationInstance().getSecondUser().get());

        final Match match = new MatchBuilderImpl().gameType(this.gameType.getGameType(players.getX(), players.getY()))
                .timer(this.timer.getTimer(players.getX(), players.getY())).build();

        this.getApplicationInstance().setMatch(match);
        return true;
    }

}
