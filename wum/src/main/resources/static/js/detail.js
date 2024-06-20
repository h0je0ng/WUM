let files=["/image/heart.jpg", "/image/fullheart.jpg"];

var movieSeq = ${movieSeq};
var userSeq = ${userSeq};

$(document).ready(function() {
    $('#img').click(function(event) {
        event.preventDefault();
     $.ajax({
            type : "POST",
            url : "/clickLike",
            dataType : "json",
            data : "movieSeq="+movieSeq+"&userSeq="+userSeq,
            error : function(){
                Rnd.alert("통신 에러","error","확인",function(){});
            },
            success : function(jdata) {
                if(jdata.resultCode == -1){
                    Rnd.alert("좋아요 오류","error","확인",function(){});
                }
                else{
                    if(jdata.likecheck == 1){
                        $("#img").attr("src","/image/fullheart.jpg");
                        $("#likecnt").empty();
                        $("#likecnt").append(jdata.likecnt);
                    }
                    else if (jdata.likecheck == 0){
                        $("#img").attr("src","/image/heart.jpg");
                        $("#likecnt").empty();
                        $("#likecnt").append(jdata.likecnt);

                    }
                }
            }
        });
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


