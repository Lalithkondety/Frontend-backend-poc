## Architecture
![.](/picture/Architech.PNG "This is a sample image.")

## Prerequisite
1. Docker-desktop (with docker and kubernetes)
2. docker hub account (with name client and backend repo)
3. kubectl cli tool to intract with k8s
4. helm cli to deploy application on k8s
5. docker login with given id

## client pages with validation
   #login page
   ![.](/picture/login_page.PNG "This is a sample image.")
   #Registration page
   ![.](/picture/registration_page.PNG "This is a sample image.")

#### note all command shold apply in docker-compse.yaml file level
## 1. Run Application with docker compose
      build code and create docker images
      Docker compose build

      run postgres backend and client application
      Docker compose up

      Browse on url 
      http://localhost
      
## 2. Run Application with Kubernets
      build docker images:

      build and push Client image
      > docker build -t <docker hub id>/client ./client  
      > docker push <docker hub id>/client


      build and push backend image
      > docker build -t <docker hub id>/backend ./server  
      > docker push <docker hub id>/backend

      crate namespace
      > kubectl create ns poc

      deploy postgres with helm chart
      > helm install db ./kube8/postgres-db/postgresql --namespace poc

      deploy backend api app
      > >helm install server ./helm-chart/server --set image.repository="<docker hub id>/backend" --set image.tag="latest"  --namespace poc

      deploy client app
      > helm install client ./helm-chart/frontend --set image.repository="<docker hub id>/client" --set image.tag="latest"  --namespace poc

      Access application 
      open 2 command line and execure below on each 
        1. kubectl port-forward svc/backend 8081:8081 -n poc
        2. kubectl port-forward svc/client 3420:80 -n poc 
       Browse on url 
        http://localhost:3420


## 3. access postgres sql database and check entries
    1. kubectl exec -it db-0 sh -n poc
       
       list databases
       > \l

       connect to database 
       > psql -U postgres 

       list table
       > \dt

       get records from table
       > select * from usertable;

