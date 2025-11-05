console.log("Script loaded...");

//change theme work

let currentTheme = getTheme();

//initial-->
document.addEventListener("DOMContentLoaded", () =>{
    changeTheme();
});

//TODO:
function changeTheme() {
  //set to web page
  changPageTheme(currentTheme,"");
   //set the listener to change theme button
  const changeThemebuttoon = document.querySelector("#theme_change_button");
  //chane the text of button
  // changeThemebuttoon.querySelector("span").textContent =
  //   currentTheme == "ligth" ? "dark" : "light";
  // const oldTheme = currentTheme;
  changeThemebuttoon.addEventListener("click", (event) => {
    let oldTheme = currentTheme;
    console.log("change theme button clicked...");
    if (currentTheme == "dark") {
      //theme ko ligth
      currentTheme = "ligth";
    } else {
      //theme ko dark
      currentTheme = "dark";
    }
    console.log(currentTheme);
    changPageTheme(currentTheme, oldTheme);
  });
}

//set theme to local storage
function setTheme(theme) {
  localStorage.setItem("theme", theme);
}

//get theme to loacal storage

function getTheme() {
  let theme = localStorage.getItem("theme");
  // if(theme)
  //     return theme;
  // else return "light";
//(or same as turnary operator)
  return theme ? theme : "light";
}
//change  current page theme
function changPageTheme(theme, oldTheme) {
  //loacal storage me update karenge
  setTheme(currentTheme);
  //remove the current theme
  if(oldTheme){
    document.querySelector("html").classList.remove(oldTheme);
  }
  //set the current theme
  document.querySelector("html").classList.add(currentTheme);
  //chane the text of button
  document
    .querySelector("#theme_change_button")
    .querySelector("span").textContent =
    currentTheme == "ligth" ? "dark" : "light";
}
//end of change theme work
