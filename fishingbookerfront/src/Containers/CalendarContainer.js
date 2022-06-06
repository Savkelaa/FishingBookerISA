import format from "date-fns/format";
import getDay from "date-fns/getDay";
import parse from "date-fns/parse";
import startOfWeek from "date-fns/startOfWeek";
import React, { useEffect, useRef, useState } from "react";
import { Calendar, dateFnsLocalizer } from "react-big-calendar";
import "react-big-calendar/lib/css/react-big-calendar.css";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import Footerr from "../Components/Common/Footerr";
import fishingClassQuickReservationServices from "../Services/FishingClassQuickReservationServices/FishingClassQuickReservationServices";
import fishingClassServices from "../Services/FishingClassServices/FishingClassServices";
import userServices from "../Services/UserServices/UserServices";

const locales = {
  "en-US": require("date-fns/locale/en-US"),
};
const localizer = dateFnsLocalizer({
  format,
  parse,
  startOfWeek,
  getDay,
  locales,
});

// const events = [
//   {
//     title: "Big Meeting",
//     allDay: false,
//     start: new Date(2022, 5, 2),
//     end: new Date(2022, 5, 10),
//   },
//   {
//     title: "Vacation",
//     start: new Date(2022, 6, 7),
//     end: new Date(2022, 6, 10),
//   },
//   {
//     title: "Conference",
//     start: new Date(2022, 5, 7),
//     end: new Date(2022, 5, 12),
//   },
// ];

export default function CalendarContainer() {
  var logedInstructor = JSON.parse(localStorage.getItem("Instructor"));

  const [newEvent, setNewEvent] = useState({
    startDate: "",
    endDate: "",
    instructor: { id: logedInstructor.id },
  });
  const [
    fishingClassReservationsByInstructor,
    setfishingClassReservationsByInstructor,
  ] = useState([]);
  const [dateSpan, setDateSpan] = useState({});
  const [allEvents, setAllEvents] = useState([]);

  var startDatePeriod = useRef();
  var endDatePeriod = useRef();

  function handleAddEvent() {
    setAllEvents([...allEvents, newEvent]);
  }

  console.log("allEvents", allEvents);

  useEffect(() => {
    fishingClassQuickReservationServices
      .getAllFishingClassReservationsByInstructor(logedInstructor.id)
      .then(({ data }) => {
        console.log("fishingClassReservations", data);
        setAllEvents(
          data.map(
            ({
              fishingClass,
              startDate,
              finishDate,
              client: { name, surname },
            }) => ({
              title: `Reservation: ${fishingClass.name} - ${name} ${surname} : ${startDate} - ${finishDate} , ${fishingClass.price} euro, ${fishingClass.maxPeople} people`,
              start: new Date(startDate),
              end: new Date(finishDate),
            })
          )
        );
      })
      .catch((error) => console.log(`error`, error));

    fishingClassQuickReservationServices
      .getAllDateSpansInstructor(logedInstructor.id)
      .then(({ data }) => {
        console.log("free", data);
        setAllEvents((allEvents) => [
          ...allEvents,
          ...data.map(({ startDate, endDate }) => ({
            title: `FREE`,
            start: new Date(startDate),
            end: new Date(endDate),
          })),
        ]);
      })
      .catch((error) => console.log(`error`, error));

    fishingClassQuickReservationServices
      .getAllFishingClassQuickReservationsByInstructor(logedInstructor.id)
      .then(({ data }) => {
        console.log("free", data);
        setAllEvents((allEvents) => [
          ...allEvents,
          ...data.map(
            ({
              fishingClass,
              startDateAction,
              finishDateAction,
              client: { name, surname },
            }) => ({
              title: `Quick Reservation: ${fishingClass.name} - ${name} ${surname} : ${startDateAction} - ${finishDateAction} , ${fishingClass.price} euro, ${fishingClass.maxPeople} people`,
              start: new Date(finishDateAction),
              end: new Date(finishDateAction),
            })
          ),
        ]);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  function createDateSpan(dateSpan) {
    userServices
      .createDateSpan(dateSpan)
      .then((data) => {
        if (data.status === 204) setDateSpan([]);
        else {
          setDateSpan(data.data.content);
          console.log("sucessfuly added a datespan.");
          alert("sucessfuly added a datespan.");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  return (
    <div>
      <h1>Calendar</h1>
      <h2>Add a new availability period </h2>
      <div>
        <input
          type="text"
          placeholder="Add Title"
          className="form-control"
          style={{ width: "20%", marginRight: "10px" }}
          value={newEvent.title}
          //  onChange={(e) => setNewEvent({ ...newEvent, title: e.target.value })}
        />
        <DatePicker
          className="form-control"
          placeholderText="Start Date"
          style={{ width: "20%", marginRight: "10px" }}
          selected={newEvent.startDate}
          ref={startDatePeriod}
          onChange={(startDate) => setNewEvent({ ...newEvent, startDate })}
        />
        <DatePicker
          className="form-control"
          placeholderText="End Date"
          style={{ width: "20%", marginRight: "10px" }}
          selected={newEvent.endDate}
          ref={endDatePeriod}
          onChange={(endDate) => setNewEvent({ ...newEvent, endDate })}
        />
        <button
          className="btn btn-info"
          stlye={{ marginTop: "10px" }}
          onClick={() => {
            handleAddEvent();

            createDateSpan(newEvent);
          }}
        >
          Add Period
        </button>
      </div>
      <Calendar
        localizer={localizer}
        events={allEvents}
        startAccessor="start"
        endAccessor="end"
        style={{
          height: 700,
          marginLeft: "50px",
          marginRight: "50px",
          marginTop: "200px",
          marginBottom: "150px",
        }}
      />
      <Footerr></Footerr>
    </div>
  );
}
