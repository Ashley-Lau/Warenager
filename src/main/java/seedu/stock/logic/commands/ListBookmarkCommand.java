package seedu.stock.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.stock.model.Model;
import seedu.stock.model.stock.Stock;
import seedu.stock.model.stock.predicates.BookmarkedPredicate;

import java.util.function.Predicate;

/**
 * Lists all persons in the address book to the user.
 */
public class ListBookmarkCommand extends ListCommand {

    public static final String LIST_WORD = "bookmark";

    public static final String MESSAGE_SUCCESS = "Listing all bookmarked stocks in inventory";

    public static final Predicate<Stock> isBookmarked = new BookmarkedPredicate();


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredStockList(isBookmarked);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
