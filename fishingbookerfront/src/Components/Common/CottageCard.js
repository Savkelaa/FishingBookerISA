import React from "react";
import  { useState, useEffect } from "react";
import {
  Card,
  ListGroup,
  ListGroupItem,
  CardGroup,
  Button,
} from "react-bootstrap";
import "../../App.css";
import cottageServices from "../../Services/CottageServices/CottageServices";
import { Link } from "react-router-dom";
import rateServices from "../../Services/RateServices/RateServices";

export default function CottageCard({ cottages }) {
  console.log("cottages", cottages);

  const [mappedCottages, setMappedCottages]=useState(cottages)

  useEffect(() => {
    cottageServices
      .getAllCottages()

      .then((data) => {
        setMappedCottages(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);


 
function SortPriceASC(){
  const numAscending = [...mappedCottages].sort((a, b) => a.price - b.price);
  setMappedCottages(numAscending)
}
function SortPriceDESC(){
  const numAscending = [...mappedCottages].sort((a, b) => b.price - a.price);
  setMappedCottages(numAscending)
}
function SortRateASC(){
  const numAscending = [...mappedCottages].sort((a, b) => a.averageRate - b.averageRate);
  setMappedCottages(numAscending)
}
function SortRateDESC(){
  const numAscending = [...mappedCottages].sort((a, b) => b.averageRate - a.averageRate);
  setMappedCottages(numAscending)
}
function SortNameASC(){
  const numAscending = [...mappedCottages].sort((a, b) => a.name > b.name ? 1 : -1);
  setMappedCottages(numAscending)
}
function SortNameDESC(){
  const numAscending = [...mappedCottages].sort((a, b) => a.name < b.name ? 1 : -1);
  setMappedCottages(numAscending)
}function rate(){
  const array=[]
   mappedCottages.map(element => {
    rateServices
    .getAvgRateByCottage(element?.id)
    .then((data) => {
      element.averageRate=data.data;
     // console.log(data.data)
     console.log(element)
      
    })
    console.log(mappedCottages)
  });
 
  
 
}
 
  return (
    <div>
      <Button onClick={()=>{
        SortPriceASC()
       
      }}>Sort PriceASC</Button>
            <Button onClick={()=>{
        SortPriceDESC()
       
      }}>Sort PriceDESC</Button>
            <Button onClick={()=>{
        SortNameASC()
       
      }}>Sort NameASC</Button>
       <Button onClick={()=>{
        SortNameDESC()
       
      }}>Sort NameDESC</Button>
<Button onClick={()=>{
        SortRateASC()
       
      }}>Sort RateASC</Button>
       <Button onClick={()=>{
        SortRateDESC()
       
      }}>Sort RateDESC</Button>


      
<Button onClick={()=>{
       rate()
       
      }}>GetRates</Button>
      {mappedCottages?.map((cottage) => (
        <div className="container">
          <div className="row gutters">
            <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
              <div className="card h-100">
                <div className="card-body">
                  <Card className="cardContainer" style={{ width: "30rem" }}>
                    <Card.Body>
                      <Card.Title className="cardTitle">
                        {cottage.name}
                      </Card.Title>
                      <Card.Text>{cottage.promoDescription}</Card.Text>
                    </Card.Body>
                    <ListGroup className="list-group-flush">
                      <ListGroupItem>Address: {cottage.address}</ListGroupItem>
                      <ListGroupItem>
                        Number of rooms : {cottage.numRooms}
                      </ListGroupItem>
                      <ListGroupItem>
                        Number of beds : {cottage.numBeds}
                      </ListGroupItem>
                      <ListGroupItem>Price: {cottage.price} euro</ListGroupItem>
                      <ListGroupItem>Rate: {cottage.averageRate} </ListGroupItem>
                    </ListGroup>
                    <Card.Body>
                      <Link to={`/cottage/${cottage.id}`}>
                        <Button
                          style={{ width: "8rem" }}
                          variant="outline-success"
                        >
                          More info
                        </Button>
                      </Link>
                    </Card.Body>
                  </Card>
                </div>
              </div>
            </div>
          </div>
        </div>
      ))}
    </div>
  );
}
