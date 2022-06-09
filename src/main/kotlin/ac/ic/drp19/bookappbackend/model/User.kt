package ac.ic.drp19.bookappbackend.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "Users")
class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @NotNull
    val username: String,

    @NotNull
    val passwdHash: String,

    @NotNull
    val name: String,

    val email: String,

    val phone: String,

    @OneToMany(mappedBy = "owner")
    val owns: List<Ownership> = emptyList(),

    @OneToMany(mappedBy = "fromUser")
    val loans: List<Loan> = emptyList(),

    @OneToMany(mappedBy = "toUser")
    val borrows: List<Loan> = emptyList()
)
