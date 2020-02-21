package game.model.player;

import game.model.card.IPlayingCard;
import game.model.player.impl.WinnerPlayerDecorator;

/**
 * The interface was created in order to enable a decorator: {@link WinnerPlayerDecorator}
 */
public interface IPlayer {

    public String getName();
    public void addCardToHand(IPlayingCard pc);
    public IPlayingCard getCard(int index);
    public IPlayingCard removeCard();
}
