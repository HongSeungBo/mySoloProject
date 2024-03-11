document.getElementById('FIDregBtn').addEventListener('click', function(){
    document.getElementById('fDetailFile').click();
})

const regExp = new RegExp("\.(exe|sh|bat|js|msi|dll)$");
const regExpImg = new RegExp("\.(jpg|jpeg|png|gif|emp)$");
const maxSize = 1024 * 1024 * 20;

function fileValidation(fileName, fileSize){
    if(!regExpImg.test(fileName)){
        console.log("이미지파일아님");
        return 0;
    }else if(regExp.test(fileName)){
        console.log("실행파일");
        return 0;
    }else if(fileSize>maxSize){
        console.log("사이즈 오버");
        return 0;
    }else{
        return 1;
    }
}

document.getElementById('fDetailFile').addEventListener('change',function(){
    let div = document.getElementById('imageBox');
    let file = document.getElementById('fDetailFile').files;
    let isOk = 1;
    isOk = fileValidation(file[0].name, file[0].size);
    const Data = file[0];
    if(isOk>0){
        tmtFile(Data).then(result=>{
            if(result!=null){
                console.log(result);
                console.log(result.uuid);
                let img = `<img src="/upload/${result.saveDir}/${result.uuid}_${result.fileName}" alt="${result.fileName}" data-uuid="${result.uuid}" data-fileNmae="${result.fileName}" data-saveDir="${result.saveDir}">`;
                console.log(img);
                div.innerHTML=img;
            }
        })
    }
})

async function tmtFile(Data){
    try {
        const url = "/football/tmtfile";
        const formData = new FormData();
        formData.append('file',Data);
        const config = {
            method: "post",
            body: formData
        };
        const resp = await fetch(url, config);
        const result = await resp.json();
        return result;
    } catch (error) {
        console.log(error);
        console.error();
    }
}


document.getElementById('AddST').addEventListener('click',function(){
    console.log("ㅎㅇㅎㅇㅎㅇ버튼클릭 성공");
    let ul = document.getElementById('AddSTZone');

})