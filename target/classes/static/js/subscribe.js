const subscribe = document.getElementById('subscribe');
const fname = document.getElementById('fname');
const lname = document.getElementById('lname');
const email = document.getElementById('email');
const topic = document.getElementById('topic');
const popup = document.getElementsByClassName('popup');
const login = document.getElementById('login')

subscribe.addEventListener('submit', e=>{
    e.preventDefault();

    const body = {
        firstName: fname.value,
        lastName: lname.value,
        email: email.value,
        topicId: Number(topic.value)
    } 
    
    fetch('/subscribe', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
          },
        body: JSON.stringify(body),

    }).then(response=>response.json()).then(data=>{
        console.log(popup)
        popup[0].style.display= 'block';
        login.style.display = 'none';
        
        
    }).catch(error=>{
        console.log(error)
    })
   
})

