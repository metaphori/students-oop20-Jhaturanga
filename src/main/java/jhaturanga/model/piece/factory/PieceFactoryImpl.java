package jhaturanga.model.piece.factory;

import jhaturanga.model.board.BoardPosition;
import jhaturanga.model.piece.Piece;
import jhaturanga.model.piece.PieceImpl;
import jhaturanga.model.piece.PieceType;
import jhaturanga.model.player.Player;

public final class PieceFactoryImpl implements PieceFactory {

    /**
     * 
     */
    private static final long serialVersionUID = 3341059957079038770L;
    private final Player owner;

    public PieceFactoryImpl(final Player owner) {
        this.owner = owner;
    }

    @Override
    public Piece getPawn(final BoardPosition piecePosition) {
        return new PieceImpl(PieceType.PAWN, piecePosition, this.owner);
    }

    @Override
    public Piece getKing(final BoardPosition piecePosition) {
        return new PieceImpl(PieceType.KING, piecePosition, this.owner);
    }

    @Override
    public Piece getQueen(final BoardPosition piecePosition) {
        return new PieceImpl(PieceType.QUEEN, piecePosition, this.owner);
    }

    @Override
    public Piece getBishop(final BoardPosition piecePosition) {
        return new PieceImpl(PieceType.BISHOP, piecePosition, this.owner);
    }

    @Override
    public Piece getKnight(final BoardPosition piecePosition) {
        return new PieceImpl(PieceType.KNIGHT, piecePosition, this.owner);
    }

    @Override
    public Piece getRook(final BoardPosition piecePosition) {
        return new PieceImpl(PieceType.ROOK, piecePosition, this.owner);
    }

    @Override
    public Piece getPiece(final PieceType type, final BoardPosition piecePosition) {
        return new PieceImpl(type, piecePosition, this.owner);
    }
}
