#include "Mat_Vec_Multiplier.h"

void Mat_Vec_Multiplier_t::init ( bool rand_init ) {
}
void Mat_Vec_Multiplier_t::clock_lo ( dat_t<1> reset ) {
  val_t Mat_Vec_Multiplier__vec_out_immed_3_0__w0;
  { Mat_Vec_Multiplier__vec_out_immed_3_0__w0 = rand_val(); }
  Mat_Vec_Multiplier__vec_out_immed_3_0__w0 = Mat_Vec_Multiplier__vec_out_immed_3_0__w0 & 4294967295;
  { Mat_Vec_Multiplier_Add_Node_12__io_vec_out_immed_in.values[0] = Mat_Vec_Multiplier__vec_out_immed_3_0__w0; }
  val_t T0__w0;
  { T0__w0 = Mat_Vec_Multiplier_Add_Node_12__io_vec_out_immed_in.values[0] | 0x0L << 32; }
  { Mat_Vec_Multiplier_Add_Node_12__io_mat_comp.values[0] = Mat_Vec_Multiplier__io_mat_in_3_0.values[0]; }
  { Mat_Vec_Multiplier_Add_Node_12__io_vec_in_comp.values[0] = Mat_Vec_Multiplier__io_vec_in_3.values[0]; }
  val_t T1__w0;
  T1__w0 = Mat_Vec_Multiplier_Add_Node_12__io_vec_in_comp.values[0] * Mat_Vec_Multiplier_Add_Node_12__io_mat_comp.values[0];
  val_t T2__w0;
  { T2__w0 = T1__w0+T0__w0; }
  val_t T3__w0;
  { T3__w0 = T2__w0; }
  T3__w0 = T3__w0 & 4294967295;
  { Mat_Vec_Multiplier_Add_Node_12__io_vec_out_immed_out.values[0] = T3__w0; }
  { Mat_Vec_Multiplier__io_vec_out_0.values[0] = Mat_Vec_Multiplier_Add_Node_12__io_vec_out_immed_out.values[0]; }
  val_t Mat_Vec_Multiplier__vec_out_immed_3_1__w0;
  { Mat_Vec_Multiplier__vec_out_immed_3_1__w0 = rand_val(); }
  Mat_Vec_Multiplier__vec_out_immed_3_1__w0 = Mat_Vec_Multiplier__vec_out_immed_3_1__w0 & 4294967295;
  { Mat_Vec_Multiplier_Add_Node_13__io_vec_out_immed_in.values[0] = Mat_Vec_Multiplier__vec_out_immed_3_1__w0; }
  val_t T4__w0;
  { T4__w0 = Mat_Vec_Multiplier_Add_Node_13__io_vec_out_immed_in.values[0] | 0x0L << 32; }
  { Mat_Vec_Multiplier_Add_Node_13__io_mat_comp.values[0] = Mat_Vec_Multiplier__io_mat_in_3_1.values[0]; }
  val_t Mat_Vec_Multiplier__vec_in_pass_through_1_3__w0;
  { Mat_Vec_Multiplier__vec_in_pass_through_1_3__w0 = rand_val(); }
  Mat_Vec_Multiplier__vec_in_pass_through_1_3__w0 = Mat_Vec_Multiplier__vec_in_pass_through_1_3__w0 & 4294967295;
  { Mat_Vec_Multiplier_Add_Node_13__io_vec_in_comp.values[0] = Mat_Vec_Multiplier__vec_in_pass_through_1_3__w0; }
  val_t T5__w0;
  T5__w0 = Mat_Vec_Multiplier_Add_Node_13__io_vec_in_comp.values[0] * Mat_Vec_Multiplier_Add_Node_13__io_mat_comp.values[0];
  val_t T6__w0;
  { T6__w0 = T5__w0+T4__w0; }
  val_t T7__w0;
  { T7__w0 = T6__w0; }
  T7__w0 = T7__w0 & 4294967295;
  { Mat_Vec_Multiplier_Add_Node_13__io_vec_out_immed_out.values[0] = T7__w0; }
  { Mat_Vec_Multiplier__io_vec_out_1.values[0] = Mat_Vec_Multiplier_Add_Node_13__io_vec_out_immed_out.values[0]; }
  val_t Mat_Vec_Multiplier__vec_out_immed_3_2__w0;
  { Mat_Vec_Multiplier__vec_out_immed_3_2__w0 = rand_val(); }
  Mat_Vec_Multiplier__vec_out_immed_3_2__w0 = Mat_Vec_Multiplier__vec_out_immed_3_2__w0 & 4294967295;
  { Mat_Vec_Multiplier_Add_Node_14__io_vec_out_immed_in.values[0] = Mat_Vec_Multiplier__vec_out_immed_3_2__w0; }
  val_t T8__w0;
  { T8__w0 = Mat_Vec_Multiplier_Add_Node_14__io_vec_out_immed_in.values[0] | 0x0L << 32; }
  { Mat_Vec_Multiplier_Add_Node_14__io_mat_comp.values[0] = Mat_Vec_Multiplier__io_mat_in_3_2.values[0]; }
  val_t Mat_Vec_Multiplier__vec_in_pass_through_2_3__w0;
  { Mat_Vec_Multiplier__vec_in_pass_through_2_3__w0 = rand_val(); }
  Mat_Vec_Multiplier__vec_in_pass_through_2_3__w0 = Mat_Vec_Multiplier__vec_in_pass_through_2_3__w0 & 4294967295;
  { Mat_Vec_Multiplier_Add_Node_14__io_vec_in_comp.values[0] = Mat_Vec_Multiplier__vec_in_pass_through_2_3__w0; }
  val_t T9__w0;
  T9__w0 = Mat_Vec_Multiplier_Add_Node_14__io_vec_in_comp.values[0] * Mat_Vec_Multiplier_Add_Node_14__io_mat_comp.values[0];
  val_t T10__w0;
  { T10__w0 = T9__w0+T8__w0; }
  val_t T11__w0;
  { T11__w0 = T10__w0; }
  T11__w0 = T11__w0 & 4294967295;
  { Mat_Vec_Multiplier_Add_Node_14__io_vec_out_immed_out.values[0] = T11__w0; }
  { Mat_Vec_Multiplier__io_vec_out_2.values[0] = Mat_Vec_Multiplier_Add_Node_14__io_vec_out_immed_out.values[0]; }
  val_t Mat_Vec_Multiplier__vec_out_immed_3_3__w0;
  { Mat_Vec_Multiplier__vec_out_immed_3_3__w0 = rand_val(); }
  Mat_Vec_Multiplier__vec_out_immed_3_3__w0 = Mat_Vec_Multiplier__vec_out_immed_3_3__w0 & 4294967295;
  { Mat_Vec_Multiplier_Add_Node_15__io_vec_out_immed_in.values[0] = Mat_Vec_Multiplier__vec_out_immed_3_3__w0; }
  val_t T12__w0;
  { T12__w0 = Mat_Vec_Multiplier_Add_Node_15__io_vec_out_immed_in.values[0] | 0x0L << 32; }
  { Mat_Vec_Multiplier_Add_Node_15__io_mat_comp.values[0] = Mat_Vec_Multiplier__io_mat_in_3_3.values[0]; }
  val_t Mat_Vec_Multiplier__vec_in_pass_through_3_3__w0;
  { Mat_Vec_Multiplier__vec_in_pass_through_3_3__w0 = rand_val(); }
  Mat_Vec_Multiplier__vec_in_pass_through_3_3__w0 = Mat_Vec_Multiplier__vec_in_pass_through_3_3__w0 & 4294967295;
  { Mat_Vec_Multiplier_Add_Node_15__io_vec_in_comp.values[0] = Mat_Vec_Multiplier__vec_in_pass_through_3_3__w0; }
  val_t T13__w0;
  T13__w0 = Mat_Vec_Multiplier_Add_Node_15__io_vec_in_comp.values[0] * Mat_Vec_Multiplier_Add_Node_15__io_mat_comp.values[0];
  val_t T14__w0;
  { T14__w0 = T13__w0+T12__w0; }
  val_t T15__w0;
  { T15__w0 = T14__w0; }
  T15__w0 = T15__w0 & 4294967295;
  { Mat_Vec_Multiplier_Add_Node_15__io_vec_out_immed_out.values[0] = T15__w0; }
  { Mat_Vec_Multiplier__io_vec_out_3.values[0] = Mat_Vec_Multiplier_Add_Node_15__io_vec_out_immed_out.values[0]; }
}
void Mat_Vec_Multiplier_t::clock_hi ( dat_t<1> reset ) {
}
void Mat_Vec_Multiplier_t::print ( FILE* f ) {
}
bool Mat_Vec_Multiplier_t::scan ( FILE* f ) {
  return(!feof(f));
}
void Mat_Vec_Multiplier_t::dump(FILE *f, int t) {
}
