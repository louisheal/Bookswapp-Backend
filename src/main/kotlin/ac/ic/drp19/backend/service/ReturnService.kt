package ac.ic.drp19.backend.service

import ac.ic.drp19.backend.repository.ReturnRepository
import org.springframework.stereotype.Service

@Service
class ReturnService(
    val returnRepository: ReturnRepository
) {

    fun findReturnsOfLoan(loanId: Long) = returnRepository.findReturnsOfLoan(loanId)
}
