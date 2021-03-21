package jhaturanga.model.savedhistory;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jhaturanga.model.board.Board;
import jhaturanga.model.game.gametypes.GameTypesEnum;
import jhaturanga.model.user.User;

public final class BoardState implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private final String matchID;

    private final Date date;

    private final User whiteUser;

    private final User blackUser;

    private final List<Board> boards;

    private final GameTypesEnum gameType;

    public BoardState(final String matchID, final Date date, final User whiteUser, final User blackUser,
            final List<Board> boards, final GameTypesEnum gameType) {
        this.matchID = matchID;
        this.date = date;
        this.whiteUser = whiteUser;
        this.blackUser = blackUser;
        this.boards = boards;
        this.gameType = gameType;
    }

    public String getMatchID() {
        return this.matchID;
    }

    public Date getDate() {
        return this.date;
    }

    public User getWhiteUser() {
        return this.whiteUser;
    }

    public User getBlackUser() {
        return this.blackUser;
    }

    public List<Board> getBoards() {
        return this.boards;
    }

    public GameTypesEnum getGameType() {
        return this.gameType;
    }

}
