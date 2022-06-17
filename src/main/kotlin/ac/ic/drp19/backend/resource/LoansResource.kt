package ac.ic.drp19.backend.resource

import ac.ic.drp19.backend.model.Loan
import ac.ic.drp19.backend.service.LoanService
import ac.ic.drp19.backend.service.ReturnService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class LoansResource(
    val loanService: LoanService,
    val returnService: ReturnService
) {

    @GetMapping("/loans")
    fun getLoans(
        @RequestParam("from", required = false) fromUserId: Long? = null,
        @RequestParam("to", required = false) toUserId: Long? = null
    ): Iterable<Loan> =
        loanService.findLoans(fromUserId, toUserId)

    @GetMapping("/loans/{loan_id}")
    fun getLoan(@PathVariable("loan_id") loanId: Long) = loanService.findById(loanId)

    @GetMapping("/loans/{loan_id}/returns")
    fun getReturnsOfLoan(@PathVariable("loan_id") loanId: Long) =
        returnService.findReturnsOfLoan(loanId)

    @PostMapping("/loans")
    fun postLoan(@RequestBody loan: LoanPost) {
        loanService.postLoan(
            loan.fromUserId,
            loan.toUserId,
            loan.bookId,
            loan.copies
        )
    }

    @PostMapping("/loans/{loan_id}/returns")
    fun postReturn(
        @PathVariable("loan_id") loanId: Long,
        @RequestBody ret: ReturnPost
    ) {
        returnService.postReturn(
            loanId,
            ret.copies
        )
    }
}

data class LoanPost(
    val fromUserId: Long,
    val toUserId: Long,
    val bookId: Long,
    val copies: Int
)

data class ReturnPost(
    val copies: Int
)
