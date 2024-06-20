let files=["/image/heart.jpg", "/image/fullheart.jpg"];

let imgs=[];
for (i=0; i<files.length; i++) {
    imgs[i] = new Image();
    imgs[i].src = files[i];
}

let next = 1;
function jjim(obj) {
    obj.src = imgs[next].src;
    next++;
    next %= imgs.length;
}


// 리뷰작성 (다시해....../ 별점이랑 같이 표시되야하고 하나만 남기도록)
function newRegister() {   
    // 새로운 p 요소를 생성하여 newP변수에 저장
    let newP = document.createElement("p");

    // 새로운 텍스트 노드 생성하여 newText변수에 저장
    let review = document.querySelector("#review");
    let newText = document.createTextNode(review.value);

    // 텍스트를 p의 자식노드로 연결
    newP.appendChild(newText);

    // 결과를 나타낼 #namelist를 가져옴
    let my_review = document.querySelector("#my_review");
    
    // newP를 nameList의 자식으로 연결
    my_review.appendChild(newP);
    
    // 다음 이름을 입력할 수 있도록 입력창의 내용을 지움
    review.value = "";
}


