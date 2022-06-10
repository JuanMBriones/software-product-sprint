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
function getExperience() {
  
  const greetings = [
    {
      'title': 'Data Engineer Intern',
      'company': 'Neoris',
      'tasks': [
        'Designed a CLI tool in Python to help more than 100 ML Engineers to test and deploy models into production.',
        'Reduced cost of Azure instance by 40% by implementing a Kubernetes Airflow instance and monitoring pod’s status using Graphana.',
        'Created a Data Warehouse architecture and created ETLs for data transformation with Python.'
      ],
      'img': {
        'path': 'images/neoris_logo.png',
        'alt': 'Neoris logo'
      }
    },
    {
      'title': 'Data Engineer Intern',
      'company': 'Neoris',
      'tasks': [
        'Designed a CLI tool in Python to help more than 100 ML Engineers to test and deploy models into production.',
        'Reduced cost of Azure instance by 40% by implementing a Kubernetes Airflow instance and monitoring pod’s status using Graphana.',
        'Created a Data Warehouse architecture and created ETLs for data transformation with Python.'
      ],
      'img': {
        'path': 'images/neoris_logo.png',
        'alt': 'Neoris logo'
      }
    },
    {
      'title': 'Data Engineer Intern',
      'company': 'Neoris',
      'tasks': [
        'Designed a CLI tool in Python to help more than 100 ML Engineers to test and deploy models into production.',
        'Reduced cost of Azure instance by 40% by implementing a Kubernetes Airflow instance and monitoring pod’s status using Graphana.',
        'Created a Data Warehouse architecture and created ETLs for data transformation with Python.'
      ],
      'img': {
        'path': 'images/neoris_logo.png',
        'alt': 'Neoris logo'
      }
    }    
  ];
  // Pick a random greeting.

  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;
}

