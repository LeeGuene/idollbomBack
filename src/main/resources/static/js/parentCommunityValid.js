// 부모 유효성 체크
const parentTitle = document.getElementById('parentPostTitle')
const parentCommunityTitle = document.getElementById('parentCommunityTitle').parentNode

const parentContent = document.getElementById('parentPostContent')
const parentCommunityContent = document.getElementById('parentCommunityContent').parentNode


function parentCommunityForm(){
    let isValid = true

    if (parentTitle.value === '') {
        parentCommunityTitle.style.display="flex"
        isValid = false
    }

    if(parentContent.value === ''){
        parentCommunityContent.style.display="flex"
        isValid = false
    }

    return isValid
}

// 수업 제목이 채워졌다면
parentTitle.addEventListener("input", function(e){
    parentCommunityTitle.style.display = 'none'
})

parentContent.addEventListener("input", function(e){
    parentCommunityContent.style.display = 'none'
})