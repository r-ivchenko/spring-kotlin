package box.sand.spring5webapp.repositories

import box.sand.spring5webapp.domain.Publisher
import org.springframework.data.repository.CrudRepository

interface PublisherRepository : CrudRepository<Publisher, Long>