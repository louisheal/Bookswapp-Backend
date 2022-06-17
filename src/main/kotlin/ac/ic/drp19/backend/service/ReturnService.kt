package ac.ic.drp19.backend.service

import ac.ic.drp19.backend.model.Return
import ac.ic.drp19.backend.repository.LoanRepository
import ac.ic.drp19.backend.repository.OwnershipRepository
import ac.ic.drp19.backend.repository.ReturnRepository
import org.springframework.stereotype.Service

@Service
class ReturnService(
    val returnRepository: ReturnRepository,
    val loanRepository: LoanRepository,
    val ownershipRepository: OwnershipRepository
) {

    fun findReturnsOfLoan(loanId: Long) = returnRepository.findReturnsOfLoan(loanId)

    fun postReturn(loanId: Long, copies: Int) {
        loanRepository.findById(loanId).ifPresent { loan ->
            val ret = Return(
                loan = loan,
                copies = copies
            )
            val ownership = ownershipRepository.findOwnership(
                loan.fromUser.id,
                loan.book.id
            )
            assert(ownership != null)
            ownership!!.currentCopies += copies
            returnRepository.save(ret)
            ownershipRepository.save(ownership!!)
        }
    }
}
