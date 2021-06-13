package repo

import kotlinx.coroutines.flow.Flow
import model.QuoteItem

interface RepositoryManager {

    suspend fun getAll(): List<QuoteItem>
    suspend fun getAllQuotes(): List<QuoteItem>

    suspend fun sortByShort(): List<QuoteItem>

    suspend fun getUnknownAuthorQuotes(): Flow<List<QuoteItem>>
}