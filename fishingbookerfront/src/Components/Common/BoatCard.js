import React, { useState, useEffect } from "react";
import boatServices from "../../Services/BoatServices/BoatServices";
import rateService from "../../Services/BoatServices/RateServices";
import {
  Card,
  ListGroup,
  ListGroupItem,
  CardGroup,
  Button,
  Container
} from "react-bootstrap";
import "../../App.css";
import { Link } from "react-router-dom";

export default function BoatCard({ boats }) {
 

  const [mappedBoats, setMappedBoats]=useState(boats)
  const [avgRate, setavgRate]= useState([]);
  const [avgRate2, setavgRate2]= useState([]);
  const [sortBoats, setSortBoats]=useState(true)


  useEffect(() => {
    boatServices
      .getAllBoats()

      .then((data) => {
        setMappedBoats(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

 
function SortPriceASC(){
  const numAscending = [...mappedBoats].sort((a, b) => a.price - b.price);
  setMappedBoats(numAscending)
}
function SortPriceDESC(){
  const numAscending = [...mappedBoats].sort((a, b) => b.price - a.price);
  setMappedBoats(numAscending)
}
function SortLengthASC(){
  const numAscending = [...mappedBoats].sort((a, b) => a.length - b.length);
  setMappedBoats(numAscending)
}
function SortLengthDESC(){
  const numAscending = [...mappedBoats].sort((a, b) => b.length - a.length);
  setMappedBoats(numAscending)
}
function SortNameASC(){
  const numAscending = [...mappedBoats].sort((a, b) => a.name > b.name ? 1 : -1);
  setMappedBoats(numAscending)
}
function SortNameDESC(){
  const numAscending = [...mappedBoats].sort((a, b) => a.name < b.name ? 1 : -1);
  setMappedBoats(numAscending)
}
 
  
  /*
  useEffect(() => {
    rateService
    .getRateBoatById(1)
      .then((data) => {
        setavgRate(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, [avgRate2]);
*/

  /*
boats.forEach(element => {
  console.log(element)
  rateService
    .getRateBoatById(element.id)
      .then((data) => {
        setavgRate(data.data);
      })
      .catch((error) => console.log(`error`, error));
    element.averageRate=avgRate;
})
*/





    
  return (
    <div>
      <Container className="cardContainer">
      <Card>
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
      </Card>
      </Container>
      {mappedBoats?.map((boat) => (
        <div className="container">
          <div className="row gutters">
            <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
              <div className="card h-100">
                <div className="card-body">
                  <Card className="cardContainer" style={{ width: "30rem" }}>
                    <Card.Body>
                      <Card.Title className="cardTitle">{boat.name}</Card.Title>
                      <Card.Text>{boat.promoDescription}</Card.Text>
                    </Card.Body>
                    <ListGroup className="list-group-flush">
                      <ListGroupItem>Type: {boat.type}</ListGroupItem>
                      <ListGroupItem>Length: {boat.length}</ListGroupItem>
                      <ListGroupItem>Address: {boat.address}</ListGroupItem>
                      <ListGroupItem>
                        Numer of motors: {boat.num_motors}
                      </ListGroupItem>
                      <ListGroupItem>
                        Motor power: {boat.motorPower}
                      </ListGroupItem>
                      <ListGroupItem>Max Speed: {boat.maxSpeed}</ListGroupItem>
                      <ListGroupItem>Status: {boat.status}</ListGroupItem>
                      <ListGroupItem>Price: {boat.price} euro</ListGroupItem>
                      <ListGroupItem>Rate: {avgRate} </ListGroupItem>
                    </ListGroup>
                    <Card.Body>
                      <Link to={`/boat/${boat.id}`}>
                        <Button
                          style={{ width: "8rem" }}
                          variant="outline-success"
                        >
                          More details
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
