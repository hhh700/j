document.getElementById('viewUsers').addEventListener('click', function() {
    // Show the list of users (mock data for now)
    document.getElementById('userList').classList.remove('hidden');
    document.getElementById('statsSection').classList.add('hidden');  // Hide stats section

    const userListItems = document.getElementById('userListItems');
    userListItems.innerHTML = '';  // Clear previous users

    // Mock list of users (replace with real data in a real app)
    const users = ['User 1', 'User 2', 'User 3'];
    users.forEach(user => {
        const li = document.createElement('li');
        li.textContent = user;
        userListItems.appendChild(li);
    });
});

document.getElementById('viewStats').addEventListener('click', function() {
    // Show the stats section
    document.getElementById('statsSection').classList.remove('hidden');
    document.getElementById('userList').classList.add('hidden');  // Hide user list

    // Mock stats data (replace with real data in a real app)
    document.getElementById('downloadsToday').textContent = '25';  // Example data
    document.getElementById('uploadsToday').textContent = '5';
    document.getElementById('totalDownloads').textContent = '1025';
    document.getElementById('totalUploads').textContent = '200';
});

document.getElementById('backButton').addEventListener('click', function() {
    // Navigate back to the previous screen (you can modify this to redirect elsewhere)
    window.history.back();  // Go back to the previous page
});

// Other functionality like adding or deleting users can be added later
