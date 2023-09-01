


const form = document.getElementById("form");
const title = document.getElementById('title');
const publisher = document.getElementById('publisher');
const topic = document.getElementById('topic')
const popup = document.getElementsByClassName('popup')


form.addEventListener('submit',(e)=>{
  e.preventDefault()
    const body = {
        publisherName: publisher.value,
        topicId: Number(topic.value),
        blog: tinyMCE.activeEditor.getContent(),
        title: title.value
    }
    fetch('/publish', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Accept': 'application/json'
        },
        body: JSON.stringify(body),
      }).then(data=>{
        console.log(data)
        popup[0].style.display= 'flex';
        publishBtn.style.display = 'none';
      }).catch(error=>{
        console.log(error)
      })  
        

    
})