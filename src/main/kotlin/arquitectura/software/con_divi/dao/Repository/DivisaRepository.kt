package arquitectura.software.con_divi.dao.Repository
import arquitectura.software.con_divi.dao.DivisasDao
import org.springframework.data.repository.PagingAndSortingRepository

interface DivisaRepository : PagingAndSortingRepository<DivisasDao, Long>