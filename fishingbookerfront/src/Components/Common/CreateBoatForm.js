import React, { useRef } from "react";
import { useHistory } from "react-router-dom";
import { useParams } from "react-router-dom";

export default function CreateBoatForm({ createBoatHandler }) {
  const name = useRef();
  const address = useRef();
  const promoDescription = useRef();
  const price = useRef();

  const num_motors = useRef();
  const motor_power = useRef();
  const max_speed = useRef();
  const length = useRef();
  const capacity = useRef();
  const cancellation_condition = useRef();
  const type = useRef();
  const image_url = useRef();

  var logedBoatOwner = JSON.parse(localStorage.getItem("BoatOwner"));

  function saveHandler(e) {
    createBoatHandler({
      name: name.current.value,
      address: address.current.value,
      promoDescription: promoDescription.current.value,
      num_motors: num_motors.current.value,
      motorPower: motor_power.current.value,
      maxSpeed: max_speed.current.value,
      length: length.current.value,
      capacity: capacity.current.value,
      cancellation_condition: cancellation_condition.current.value,
      type: type.current.value,
      boatOwner: { id: logedBoatOwner.id },
      price: price.current.value,
      
    });
  }

  console.log("id", logedBoatOwner.id);

  return (
    <form action="javascript:void(0);" onSubmit={saveHandler}>
      <div className="container">
        <div className="row gutters">
          <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
            <div className="card h-100">
              <div className="card-body">
                <div className="row gutters">
                  <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <h5 className="mb-2 text-primary">
                      Create Boat
                    </h5>
                  </div>
                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="start_date_action">Name</h6>
                    <input
                      ref={name}
                      type="text"
                      className="form-control"
                      id="startAction"
                    />
                  </div>
                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="end_date_action">Address</h6>
                    <input
                      ref={address}
                      type="text"
                      className="form-control"
                      id="lastAction"
                    />
                  </div>
                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="end_date_action">Promotion Description</h6>
                    <input
                      ref={promoDescription}
                      type="text"
                      className="form-control"
                      id="lastAction"
                    />
                  </div>
                  
                  
                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="start_date">Number of motors</h6>
                    <input
                      ref={num_motors}
                      type="text"
                      className="form-control"
                      id="last"
                    />
                  </div>

                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="start_date">Motor power</h6>
                    <input
                      ref={motor_power}
                      type="text"
                      className="form-control"
                      id="last"
                    />
                  </div>

                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="start_date">Type</h6>
                    <input
                      ref={type}
                      type="text"
                      className="form-control"
                      id="last"
                    />
                  </div>

                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="start_date">Length</h6>
                    <input
                      ref={length}
                      type="text"
                      className="form-control"
                      id="last"
                    />
                  </div>

                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="start_date">Max speed</h6>
                    <input
                      ref={max_speed}
                      type="text"
                      className="form-control"
                      id="last"
                    />
                  </div>

                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="start_date">Capacity</h6>
                    <input
                      ref={capacity}
                      type="text"
                      className="form-control"
                      id="last"
                    />
                  </div>





                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="start_date">Price</h6>
                    <input
                      ref={price}
                      type="text"
                      className="form-control"
                      id="last"
                    />
                  </div>

                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="start_date">Cancellation condition(number is percentage of price you have to pay to cancel)</h6>
                    <input
                      ref={cancellation_condition}
                      type="text"
                      className="form-control"
                      id="last"
                    />
                  </div>

                </div>
                <div className="row gutters">
                  <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <div className="text-right">
                      <button
                        type="submit"
                        id="submit"
                        name="submit"
                        className="btn btn-success"
                      >
                        Create
                      </button>
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
