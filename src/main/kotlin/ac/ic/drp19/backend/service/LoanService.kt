package ac.ic.drp19.backend.service

import ac.ic.drp19.backend.model.Loan
import ac.ic.drp19.backend.repository.BookRepository
import ac.ic.drp19.backend.repository.LoanRepository
import ac.ic.drp19.backend.repository.UsersRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class LoanService(
    val loanRepository: LoanRepository,
    val usersRepository: UsersRepository,
    val bookRepository: BookRepository
) {

    fun findLoans(fromUserId: Long?, toUserId: Long?): Iterable<Loan> {
        if (toUserId != null) {
            if (fromUserId != null) {
                return loanRepository.findLoansFromUserToUser(fromUserId, toUserId)
            }
            return loanRepository.findLoansToUser(toUserId)
        } else {
            if (fromUserId != null) {
                return loanRepository.findLoansFromUser(fromUserId)
            }
        }
        return loanRepository.findAll()
    }

    fun findById(loanId: Long) = loanRepository.findByIdOrNull(loanId)

    fun postLoan(
        fromUserId: Long,
        toUserId: Long,
        bookId: Long,
        copies: Int
    ) {
        val fromUser = usersRepository.findById(fromUserId)
        val toUser = usersRepository.findById(toUserId)
        val book = bookRepository.findById(bookId)
        fromUser.ifPresent { from ->
            toUser.ifPresent { to ->
                book.ifPresent { book ->
                    val loan = Loan(
                        fromUser = from,
                        toUser = to,
                        book = book,
                        copies = copies
                    )
                    loanRepository.save(loan)
                }
            }
        }
    }
}
