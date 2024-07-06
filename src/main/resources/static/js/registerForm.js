const dayContainer = document.querySelector(".day");
const monthContainer = document.querySelector(".month");
const yearContainer = document.querySelector(".year");
const hourContainer = document.querySelector(".hour");


const days = document.querySelectorAll(".day > li");
const months = document.querySelectorAll(".month > li");
const years = document.querySelectorAll(".year > li");
const hours = document.querySelectorAll(".hour > li");

const dayResult = document.querySelector(".day-select");
const monthResult = document.querySelector(".month-select");
const yearResult = document.querySelector(".year-select");
const hourResult = document.querySelector(".hour-select");

// day와 관련된 이벤트 (마우스 over, leave)
dayContainer.addEventListener("mouseleave", (e)=>{
  e.currentTarget.style.overflow = 'hidden';
});

dayContainer.addEventListener("mouseover", (e)=>{
  e.currentTarget.style.overflow = 'scroll';
});

// =============================================

// month와 관련된 이벤트 (마우스 over, leave)
monthContainer.addEventListener("mouseleave", (e)=>{
  e.currentTarget.style.overflow = 'hidden';
});

monthContainer.addEventListener("mouseover", (e)=>{
  e.currentTarget.style.overflow = 'scroll';
});

// =============================================

// year와 관련된 이벤트 (마우스 over, leave)
yearContainer.addEventListener("mouseleave", (e)=>{
  e.currentTarget.style.overflow = 'hidden';
});


// hour와 관련된 이벤트 (마우스 over, leave)
hourContainer.addEventListener("mouseover", (e)=>{
  e.currentTarget.style.overflow = 'scroll';
});

hourContainer.addEventListener("mouseleave", (e)=>{
  e.currentTarget.style.overflow = 'hidden';
});

// select한 연, 월, 일 및 시간이 출력되도록 한다.
days.forEach((day) =>{
  day.addEventListener("click", (e)=>{

    dayResult.textContent = e.currentTarget.textContent;
  })
});

months.forEach((month) =>{
  month.addEventListener("click", (e)=>{
    monthResult.textContent = e.currentTarget.textContent;
  })
});

years.forEach((year) =>{
  year.addEventListener("click", (e)=>{
    yearResult.textContent = e.currentTarget.textContent;
  })
});

hours.forEach((hour) =>{
  hour.addEventListener("click", (e)=>{
    hourResult.textContent = e.currentTarget.textContent;
  })
});


