let content = document.getElementsByTagName('body')[0];
let darkMode = document.getElementById('dark-mode');
darkMode.addEventListener('click', function () {
    darkMode.classList.toggle('active');
    content.classList.toggle('night');
})