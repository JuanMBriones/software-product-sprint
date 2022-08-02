// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */


async function fetchExperienceJSON() {
  const response = await fetch("./experience.json")
  const experience = await response.json();
  return experience;
}

let cont = 0;

fetchExperienceJSON().then(experience => {
  for (var key in experience) {
    var title = experience[key].title;
    var company = experience[key].company;
    var tasks = [];
    
    var list_tasks = document.createElement('ul');
    list_tasks.class = 'list';
    list_tasks.innerHTML = '';
      
    for(var task in experience[key].tasks) {
      tasks.push(experience[key].tasks[task]);
      list_tasks.innerHTML += '<li>' + experience[key].tasks[task] + '</li>';
    }
      
    var img_path = experience[key].img.path
    var img_alt = experience[key].img.alt
    
    var section = document.createElement('section');
    section.classList.add("project");
    
    if(cont%2) {
        section.classList.add("blue");
    }

    var container = document.createElement('div');
    container.classList.add("container");

    var row = document.createElement('div');
    row.classList.add("row");
    
    var left_col = document.createElement('div');
    left_col.classList.add("col-sm");

    if(!(cont%2)) {
        left_col.classList.add("right-alignment");
    }

    left_col.innerHTML = 
        '<h2>Lorem ipsum dolor sit amet consectetur, <br /> adipisicing elit.</h2>' +
        '<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Maiores necessitatibus labore laboriosam quibusdam repellat itaque nisi earum cum omnis magni! Nesciunt in dicta dolor veniam voluptate inventore voluptatibus, quasi odit?</p>' + 
        '<a href="" class="button">See more</a>';

    var right_col = document.createElement('div');
    right_col.classList.add("col-sm");

    var figure = document.createElement('figure');
    figure.innerHTML = 
        '<img src='+ img_path +' alt='+ img_alt +'>' +
        '<figcaption>Twitter Logo🎉</figcaption>';
    
    right_col.appendChild(figure);
    
    if(cont%2) {
        row.appendChild(right_col);
        row.appendChild(left_col);
    }
    else {
        row.appendChild(left_col);
        row.appendChild(right_col);
    }
    
    container.appendChild(row);
    section.appendChild(container);
    
    document.getElementById('experience').appendChild(section);

    cont += 1;
  }
});




