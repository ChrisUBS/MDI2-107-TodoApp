package com.example.mdi2_107_todoapp.todoapp

import com.example.mdi2_107_todoapp.TodoViewModel
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import org.junit.Before
import org.junit.Test

class TodoViewModelTest {
    // The system under test recreated before each test
    private lateinit var viewModel: TodoViewModel

    @Before
    fun setUp() {
        viewModel = TodoViewModel()
    }

    @Test
    fun add_Task_withValidTitle_appearsInList() {
        // Arrange - The setUp() already created and empty ViewModel

        // Act - Call the function we want to test
        viewModel.addTask("Do exercise")

        // Assert - Verify the result
        assertEquals(1, viewModel.getTaskCount())
        assert(viewModel.containsTask("Do exercise"))
    }

    @Test
    fun add_Task_withBlankTitle_isIgnored() { // "    "
        viewModel.addTask("   ")
        assertEquals(0, viewModel.getTaskCount())
        assert(!viewModel.containsTask("   "))
    }

    @Test
    fun add_Task_withEmptyString_isIgnored() { // ""
        viewModel.addTask("")
        assertEquals(0, viewModel.getTaskCount())
        assert(!viewModel.containsTask(""))
    }

    @Test
    fun add_Task_titleIsTrimmed() { // " Do exercise "
        viewModel.addTask("  Do exercise  ")
        assertEquals(1, viewModel.getTaskCount())
        assert(viewModel.containsTask("Do exercise"))
    }

    // REMOVE TASK
    @Test
    fun removeTask_withValidId_removesTask() {
        // Arrange - add a task first so we have something to remove
        viewModel.addTask("Do exercise")
        val taskId = viewModel.tasks[0].id

        // Act
        viewModel.removeTask(taskId)

        // Assert
        assertEquals(0, viewModel.getTaskCount())
        assertFalse(viewModel.containsTask("Do exercise"))
    }

    // Challenge
    @Test
    fun removeTask_withInvalidId_doesNothing() {
        viewModel.addTask("Do exercise")
        val taskId = viewModel.tasks[0].id
        viewModel.removeTask(taskId + 1)
        assertEquals(1, viewModel.getTaskCount())
        assert(viewModel.containsTask("Do exercise"))
    }
}