const blog =document.getElementById('blog')
const form = document.getElementById('form')
const search = document.getElementById('search')
// const html=''
const all = document.getElementById('all')
let jsonData = null

const runData = (data)=>{
    blog.innerHTML=''
    data
    .map(e=>{
        
        const el = document.createElement('div')
        el.classList.add('card')
        el.addEventListener('click', ()=>{
            blog.innerHTML = `<div>
            <h2>${e.title}</h2>
            ${e.blog}
            <h3>Questions</h3>
            <div class="feedback">
                <input type="text" placeholder="Name">
                <input type="text" placeholder="Email">
                <textarea placeholder="feedback here"></textarea>
                <button>Submit</button>
            </div>
            </div>`
        })
        let body = e.blog
        body = body.substr(0, 200).replaceAll('<p>', '')+' Read more'
        el.innerHTML=`
        <div class="any">
            <h2>${e.title}</h2>
            <!--<h5>${e.topic.topic}</h5>
            <p>${body}</p>
            <i><p>${e.publisherName}</p></i>-->
            
        </div>
        `
        blog.appendChild(el)
    })
}
window.onload = () =>{  
    const url = new URLSearchParams(window.location.search)
    const title = url.get('title')
    console.log(title)
    // let topic = null
   
   
   
    fetch('/all_blog', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        
        },
    })
    .then(response=>
        response.json())
        .then(data=>{
            jsonData = data
            if (title){
                data= data.filter(e=>e.title==title)
                console.log(data)
                data.map(e=>{
                const el = document.createElement('div')
                el.classList.add('card')
                    blog.innerHTML = `<div>
                    <h2>${e.title}</h2>
                    ${e.blog}
                    </div>`})
                // blog.appendChild(el)
    
            }
            // else 
            // runData(data)
   
        })
        .catch(error=>{
            console.log('Error:', error)
    })

//     const filtr=(value)=>{
//          return jsonData.filter(e=>e.topic.topic==value)
//     }

//     arr.map((e, i)=>{
//         e.addEventListener('click', e=>{
//         while(blog.hasChildNodes()){
//             blog.removeChild(blog.firstChild)
//         }
//         runData(filtr(e.target.value))
//     })
    
// })
    all.addEventListener('click', ()=>runData(jsonData));
    form.addEventListener('submit', (e)=>{
        e.preventDefault();
        let data = []
        jsonData.map(e=>{
            if ((e.title).toLowerCase().includes((search.value).toLowerCase()))
                data = [...data, e]
        })
        while(blog.hasChildNodes()){
            blog.removeChild(blog.firstChild)
        }
        runData(data)

    })
}


    