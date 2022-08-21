const axios = require("axios");

const fishingClassQuickReservationServices = {
  createFishingClassQuickReservation: (fishingClassQuickReservation) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}fishingClassQuickReservations`,
      fishingClassQuickReservation
    );
  },

  DELFishingClassQuickReservation: (fishingClassQuickReservationId ) => {
    return axios.delete(
      `${process.env.REACT_APP_API_URL}fishingClassQuickReservations/${fishingClassQuickReservationId}`
      
    );
  },

  getAllFishingClassReservationsByInstructor: (instructorId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassReservationInstructor?instructorId=${instructorId}`
    );
  },

  getAllFishingClassReservationsFree: () => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassQuickReservations2`
    );
  },

  getAllFishingClassQuickReservationsByInstructor: (instructorId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassQuickReservationInstructor?instructorId=${instructorId}`
    );
  },

  getAllFishingClassReservationsByClient: (clientId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassQuickReservationsByClient?clientId=${clientId}`
    );
  },

  getAllFishingClassReservations2ByClient: (clientId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassReservationsClient?clientId=${clientId}`
    );
  },
 

  createFishingClassReservation: (fishingClassReservation) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}fishingClassReservations`,
      fishingClassReservation
    );
  },

  getAllFishingClass: () => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClass`
    );
  },

  
  //RATES
  createInstructorRate: (rate) => {
    return axios.post(`${process.env.REACT_APP_API_URL}instructorRates`, rate);
  },

  createFishingClassRate: (rate) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}fishingClassRates`,
      rate
    );
  },

  getAllFishingClassQuickReservationsByFishingClass: (fishingClassId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassQuickReservationFC?fishingClassId=${fishingClassId}`
    );
  },

  /// ADD additional services to fishing class quick reservations

  addAdditionalServiceToFishingClassQuickReservation: (
    fishingClassQuickReservationId,
    posedovanje
  ) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}fishingClassQuickReservations/${fishingClassQuickReservationId}/additionalServices`,
      posedovanje
    );
  },

  getAllAdditionalServices: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}additionalServices`);
  },

  getAllAdditionalServiceNames: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}additionalServicesNames`);
  },

  getAllDateSpansInstructor: (instructorId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}dateSpanInstructor?instructorId=${instructorId}`
    );
  },

  /// UKUPNA KOLICINA NOVCA PO REZERVACIJAMA
  //FISHING CLASS

  getTotalPriceCompletedFishinClassReservations: () => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}priceCompletedFishingClassReservation`
    );
  },

  getTotalPriceCompletedFishinClassQuickReservations: () => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}priceCompletedFishingClassQuickReservation`
    );
  },

  //BOAT

  getTotalPriceCompletedBoatReservations: () => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}priceCompletedBoatReservation`
    );
  },

  getTotalPriceCompletedBoatQuickReservations: () => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}priceCompletedBoatQuickReservation`
    );
  },

  //COTTAGE

  getTotalPriceCompletedCottageReservations: () => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}priceCompletedCottageReservation`
    );
  },

  getTotalPriceCompletedCottageQuickReservations: () => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}priceCompletedCottageQuickReservation`
    );
  },

  //CLIENT-------------------------------------------------------------------

  getAllFishingClassReservationsByClientDateAsc: (clientId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}finishedFishingClassQuickReservationsByClientSortedByDateAsc?clientId=${clientId}`
    );
  },

  getAllFishingClassReservationsByClientDateDesc: (clientId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}finishedFishingClassQuickReservationsByClientSortedByDateDesc?clientId=${clientId}`
    );
  },

  getAllFishingClassReservationsByClientDurationAsc: (clientId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}finishedFishingClassQuickReservationsByClientSortedByDurationAsc?clientId=${clientId}`
    );
  },

  getAllFishingClassReservationsByClientDurationDesc: (clientId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}finishedFishingClassQuickReservationsByClientSortedByDurationDesc?clientId=${clientId}`
    );
  },
};

export default fishingClassQuickReservationServices;
