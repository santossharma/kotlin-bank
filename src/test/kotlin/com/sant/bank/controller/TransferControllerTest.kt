package com.sant.bank.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.sant.bank.model.TransactionDTO
import com.sant.bank.repository.TransactionRepository
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

/**
 * Created by santoshsharma on 25 May, 2022
 */

@WebMvcTest
class TransferControllerTest(@Autowired val mockMvc: MockMvc) {

    @MockBean
    private lateinit var transactionRepository: TransactionRepository


    @Test
    fun `should submit transaction with success`() {
        val transfer = TransactionDTO(
            value = 1.50,
            description = "transfer to Kotlin",
            targetAccount = "N1234222323"
        )

        every { transactionRepository.save(any()) } returns mockk()

        mockMvc.post("/transfer/new") {
            content=ObjectMapper().writeValueAsString(transfer)
            contentType= MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
        }
        .andDo { println() }
        .andExpect { status { isOk() } }
    }
}