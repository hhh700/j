// Array to hold scroll data (name and ID)
let scrolls = [];

// Function to show a specific section and hide the others
function showSection(sectionId) {
  const sections = document.querySelectorAll('section');
  sections.forEach(section => section.classList.remove('active'));
  document.getElementById(sectionId).classList.add('active');

  // Special handling for when 'myScrolls' is shown to update the table
  if (sectionId === 'myScrolls') {
    updateScrollTable();
  }
}

// Function to update the "My Scrolls" table with new scrolls
function updateScrollTable() {
  const tableBody = document.querySelector('#scrollTable tbody');
  tableBody.innerHTML = ''; // Clear the table body before repopulating

  scrolls.forEach((scroll, index) => {
    const row = document.createElement('tr');

    const nameCell = document.createElement('td');
    nameCell.textContent = scroll.name;
    row.appendChild(nameCell);

    const idCell = document.createElement('td');
    idCell.textContent = scroll.id;
    row.appendChild(idCell);

    const actionCell = document.createElement('td');
    const editButton = document.createElement('button');
    editButton.textContent = 'Edit';
    editButton.onclick = function () {
      editScroll(index);
    };
    actionCell.appendChild(editButton);

    const deleteButton = document.createElement('button');
    deleteButton.textContent = 'Delete';
    deleteButton.onclick = function () {
      deleteScroll(index);
    };
    actionCell.appendChild(deleteButton);

    row.appendChild(actionCell);
    tableBody.appendChild(row);
  });
}

// Function to add a scroll
function saveScroll() {
  const scrollName = document.getElementById('scrollName').value;
  const scrollId = document.getElementById('scrollId').value;

  if (scrollName && scrollId) {
    // Add the new scroll to the scrolls array
    scrolls.push({ name: scrollName, id: scrollId });
    alert('Scroll added successfully!');

    // Clear the input fields after adding the scroll
    document.getElementById('scrollName').value = '';
    document.getElementById('scrollId').value = '';

    // Go back to the "My Scrolls" section to view the added scroll
    showSection('myScrolls');
  } else {
    alert('Please fill in all scroll details.');
  }
}

// Function to edit a scroll (to be implemented)
function editScroll(index) {
  const scroll = scrolls[index];
  const newName = prompt('Enter new scroll name:', scroll.name);
  const newId = prompt('Enter new scroll ID:', scroll.id);

  if (newName && newId) {
    scrolls[index] = { name: newName, id: newId };
    alert('Scroll updated!');
    updateScrollTable(); // Update the table with the new scroll data
  }
}

// Function to delete a scroll
function deleteScroll(index) {
  if (confirm('Are you sure you want to delete this scroll?')) {
    scrolls.splice(index, 1); // Remove the scroll from the array
    alert('Scroll deleted!');
    updateScrollTable(); // Update the table after deletion
  }
}

// Other existing functions like login, register, etc.

// Dummy login function for now
function login() {
  const userId = document.getElementById('id').value;
  const password = document.getElementById('password').value;

  if (userId && password) {
    document.getElementById('username').innerText = userId;
    showSection('dashboard');
  } else {
    alert('Please enter your ID and password.');
  }
}

// Dummy registration function for now
function register() {
  const firstName = document.getElementById('firstName').value;
  const lastName = document.getElementById('lastName').value;
  const email = document.getElementById('email').value;

  if (firstName && lastName && email) {
    alert('Registration successful!');
    showSection('login');
  } else {
    alert('Please fill all fields.');
  }
}

// Dummy profile save function
function saveProfile() {
  const firstName = document.getElementById('editFirstName').value;
  const lastName = document.getElementById('editLastName').value;

  if (firstName && lastName) {
    alert('Profile saved!');
    showSection('dashboard');
  } else {
    alert('Please fill in your profile details.');
  }
}

// Dummy logout function
function logout() {
  alert('Logged out!');
  showSection('login');
}
