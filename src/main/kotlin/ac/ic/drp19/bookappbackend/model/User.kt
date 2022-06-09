package ac.ic.drp19.bookappbackend.model

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
@Table(name = "Users")
class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @NotNull
    var username: String,

    @NotNull
    var passwdHash: String,

    @NotNull
    var name: String,

    var email: String,

    var phone: String,

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    var joinDate: Date = Date.valueOf(LocalDate.now()),

    @OneToMany(mappedBy = "owner")
    var owns: List<Ownership> = emptyList(),

    @OneToMany(mappedBy = "fromUser")
    var loans: List<Loan> = emptyList(),

    @OneToMany(mappedBy = "toUser")
    var borrows: List<Loan> = emptyList()
)
