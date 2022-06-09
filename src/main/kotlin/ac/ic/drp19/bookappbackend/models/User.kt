package ac.ic.drp19.bookappbackend.models

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "Users")
class User(
    @Id
    val username: String,

    @NotNull
    val passwdHash: String,

    @NotNull
    val name: String,

    val email: String,

    val phone: String,

    @OneToMany(mappedBy = "owner")
    val owns: List<Ownership>,

    @OneToMany(mappedBy = "fromUser")
    val loans: List<Loan>,

    @OneToMany(mappedBy = "toUser")
    val borrows: List<Loan>
)
