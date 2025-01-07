// HTML elements required 
// might wanna swap to checkboxes instead of crossing task out with an on-clikc event listener
const taskInput = document.getElementById('taskInput');
const addTaskButton = document.getElementById('addTaskButton');
const taskList = document.getElementById('taskList');


function addTask() {
  const taskText = taskInput.value.trim();
  
  if (taskText === '') {
    alert('Please enter a task dummy!');
    return;
  }

  // new list item using li
  const li = document.createElement('li');
  
  // create a span element to hold the task description
  const taskSpan = document.createElement('span');
  taskSpan.textContent = taskText;
  
  // remove button
  const removeButton = document.createElement('button');
  removeButton.textContent = 'Remove';
  removeButton.classList.add('remove');
  
  // append the task description and remove button to the list item
  li.appendChild(taskSpan);
  li.appendChild(removeButton);
  
  // add the new task to the task list
  taskList.appendChild(li);
  
  // Clear the input field after adding the task
  taskInput.value = '';

  // event listener for removing the task
  removeButton.addEventListener('click', () => {
    taskList.removeChild(li);
  });

  // event listener for marking the task as completed
  li.addEventListener('click', () => {
    li.classList.toggle('completed');
  });
}

// event listener for the "Add Task" button
addTaskButton.addEventListener('click', addTask);

// event listener for the "Enter" key to add a task
taskInput.addEventListener('keypress', (event) => {
  if (event.key === 'Enter') {
    addTask();
  }
});
