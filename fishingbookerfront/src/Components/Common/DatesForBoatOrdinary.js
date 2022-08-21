import React, { useRef, useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import { Link } from "react-router-dom";
import {
    Button,
  } from "react-bootstrap";

export default function CreateBoatReservation(
  
) {
  const startDate = useRef();
  const finishDate = useRef();
  


  let { id } = useParams();
  
  


  

  return (
    <form action="javascript:void(0);" >
      <div className="container">
        <div className="row gutters">
          <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
            <div className="card h-100">
              <div className="card-body">
                <div className="row gutters">
                  <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <h5 className="mb-2 text-primary">Create OrdinaryBoatReservation</h5>
                  </div>
                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="start_date_action">Start date:</h6>
                    <input
                      ref={startDate}
                      type="date"
                      className="form-control"
                      id="startAction"
                    />
                  </div>
                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="end_date_action">The last day: </h6>
                    <input
                      ref={finishDate}
                      type="date"
                      className="form-control"
                      id="lastAction"
                    />
                  </div>

                  
                </div>
                <div className="row gutters">
                  <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <div className="text-right">
                        <Link
                        to={`/createOrdinaryBoat`}>
                      <Button onClick={ ()=>{
                     
                        localStorage.setItem('StartDate', JSON.stringify(startDate.current.value))
                        localStorage.setItem('FinishDate', JSON.stringify(finishDate.current.value))
                      }
                      
                      }
                        type="submit"
                        id="submit"
                        name="submit"
                        className="btn btn-success"
                      >
                        Create
                      </Button>
                      </Link>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </form>
  );
}
