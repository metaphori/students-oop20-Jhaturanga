package jhaturanga.model.piece.movement;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jhaturanga.model.board.Board;
import jhaturanga.model.board.BoardPosition;
import jhaturanga.model.piece.Piece;
import jhaturanga.model.player.PlayerColor;

public class PawnVariantPieceMovementStrategyFactory extends ClassicPieceMovementStrategyFactory {

    /*
     * The increment of the piece. The white goes from bottom to up so the row is
     * incremented by 1 The black goes from top to bottom so the row is incremented
     * by -1
     */
    @Override
    public final PieceMovementStrategy getPawnMovementStrategy(final Piece piece) {
        return (final Board board) -> {
            final int increment = piece.getPlayer().getColor().equals(PlayerColor.WHITE)
                    ? AbstractPieceMovementStrategyFactory.SINGLE_INCREMENT
                    : -AbstractPieceMovementStrategyFactory.SINGLE_INCREMENT;

            final Predicate<BoardPosition> checkDirectionAndDistance = (
                    pos) -> Math.signum((pos.getY() - piece.getPiecePosition().getY()) * increment) >= 0
                            && this.distanceBetweenBoardPositions(pos, piece.getPiecePosition())
                                    .getX() <= SINGLE_INCREMENT
                            && this.distanceBetweenBoardPositions(pos, piece.getPiecePosition())
                                    .getY() <= SINGLE_INCREMENT;

            return Stream.concat(
                    this.getRookMovementStrategy(piece).getPossibleMoves(board).stream()
                            .filter(checkDirectionAndDistance::test),
                    this.getBishopMovementStrategy(piece).getPossibleMoves(board).stream()
                            .filter(checkDirectionAndDistance::test))
                    .collect(Collectors.toSet());
        };
    }
}
