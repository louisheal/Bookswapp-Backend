package ac.ic.drp19.bookappbackend.models

import com.sun.istack.NotNull
import java.sql.Date
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Book(
    @Id
    val isbn: String,

    @NotNull
    val title: String,

    val published: Date,

    @OneToMany(mappedBy = "book")
    val owners: List<Ownership>
)
