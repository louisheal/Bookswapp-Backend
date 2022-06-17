package ac.ic.drp19.backend.model

import ac.ic.drp19.backend.util.ExposeId
import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonFormat
import java.sql.Date
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@ExposeId
@Table(name = "Users")
class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @NotNull
    var username: String,

    @NotNull
    var passwdHash: String,

    @NotNull
    var name: String,

    var email: String,

    var phone: String,

    @JsonFormat(pattern = "yyyy-MM-dd")
    var joinDate: Date = Date.valueOf(LocalDate.now()),

    @OneToMany(mappedBy = "owner")
    @JsonBackReference(value = "user-owns")
    var owns: List<Ownership> = emptyList(),

    @OneToMany(mappedBy = "fromUser")
    @JsonBackReference(value = "user-loans")
    var loans: List<Loan> = emptyList(),

    @OneToMany(mappedBy = "toUser")
    @JsonBackReference(value = "user-borrows")
    var borrows: List<Loan> = emptyList()
)
