console.log('fcode'+fcodeVal);
document.addEventListener('click',function(e){
    if(e.target.classList.contains('Reser-Btn')){
        console.log('버튼1 ㅎㅇ');
        let fcode = e.target.dataset.fcode;
        let stadiumDetailName = e.target.dataset.stadiumdetailname;
        let num = e.target.dataset.num;
    }
    else if(e.target.classList.contains('Update-Btn')){
        console.log('버튼2 ㅎㅇ');
        let fcode = e.target.dataset.fcode;
        let stadiumDetailName = e.target.dataset.stadiumdetailname;
        let stadiumSize = e.target.dataset.stadiumsize;
        let num = e.target.dataset.num;
        let div = document.getElementById('changeInfo');
        div.style.display='block';
        let infodiv = `<input type="text" id="stdiumDetailName" value="${stadiumDetailName}">`;
        infodiv += `<input type="text" id="stadiumSize" value="${stadiumSize}">`;
        infodiv += `<button type="button" id="updateInfo">확인</button>`;
        infodiv += `<button type="button" id="cancleInfo">취소</button>`;
        div.innerHTML=infodiv;
    }
    else if(e.target.classList.contains('Delete-Btn')){
        console.log('버튼3 ㅎㅇ');
        let fcode = e.target.dataset.fcode;
        let stadiumDetailName = e.target.dataset.stadiumdetailname;
        let num = e.target.dataset.num;
    }
    else if(e.target.id='updateInfo'){
        let div = document.getElementById('changeInfo');
        div.style.display='none';
        let fcode = fcodeVal;
        let stadiumDetailName = document.getElementById('stadiumDetailName').value;
        let stadiumSize = document.getElementById('stadiumSize').value;
        let Data = {
            fcode : fcode,
            stadiumDetailName : stadiumDetailName,
            stadiumSize : stadiumSize
        }
        UpdateStadiumDetail(Data).then(result=>{

        })
    }
    else if(e.target.id='cancleInfo'){
        let div = document.getElementById('changeInfo');
        div.style.display='none';
    }
})

async function UpdateStadiumDetail(Data){
    try {
        const url = "/football/UpdateDetail";
        const config = {
            method: "post",
            body: Data
        };
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error);
        console.error();
    }
}